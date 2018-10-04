/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.hops.hopsworks.common.jobs.flink;


import org.apache.flink.client.deployment.ClusterDeploymentException;
import org.apache.flink.client.deployment.ClusterSpecification;
import org.apache.flink.client.program.ClusterClient;
import org.apache.flink.client.program.rest.RestClusterClient;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.runtime.jobgraph.JobGraph;
import org.apache.flink.yarn.entrypoint.YarnJobClusterEntrypoint;
import org.apache.flink.yarn.entrypoint.YarnSessionClusterEntrypoint;

import org.apache.hadoop.yarn.api.records.ApplicationId;
import org.apache.hadoop.yarn.api.records.ApplicationReport;
import org.apache.hadoop.yarn.client.api.YarnClient;
import org.apache.hadoop.yarn.conf.YarnConfiguration;


/**
 *
 * @author ahmad
 */
public class HopsYarnClusterDescriptor extends HopsAbstractYarnClusterDescriptor {

  public HopsYarnClusterDescriptor(
          Configuration flinkConfiguration,
          YarnConfiguration yarnConfiguration,
          String configurationDirectory,
          YarnClient yarnClient,
          boolean sharedYarnClient) {
    super(
            flinkConfiguration,
            yarnConfiguration,
            configurationDirectory,
            yarnClient,
            sharedYarnClient);
  }

  @Override
  protected String getYarnSessionClusterEntrypoint() {
    return YarnSessionClusterEntrypoint.class.getName();
  }

  @Override
  protected String getYarnJobClusterEntrypoint() {
    return YarnJobClusterEntrypoint.class.getName();
  }

  @Override
  public ClusterClient<ApplicationId> deployJobCluster(
          ClusterSpecification clusterSpecification,
          JobGraph jobGraph,
          boolean detached) throws ClusterDeploymentException {

    // this is required because the slots are allocated lazily
    jobGraph.setAllowQueuedScheduling(true);

    try {
      return deployInternal(
              clusterSpecification,
              "Flink per-job cluster",
              getYarnJobClusterEntrypoint(),
              jobGraph,
              detached);
    } catch (Exception e) {
      throw new ClusterDeploymentException("Could not deploy Yarn job cluster.", e);
    }
  }

  @Override
  protected ClusterClient<ApplicationId> createYarnClusterClient(
          HopsAbstractYarnClusterDescriptor descriptor,
          int numberTaskManagers,
          int slotsPerTaskManager,
          ApplicationReport report,
          Configuration flinkConfiguration,
          boolean perJobCluster) throws Exception {
    return new RestClusterClient<>(
            flinkConfiguration,
            report.getApplicationId());
  }

 
}
