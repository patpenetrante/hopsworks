/*
 * Changes to this file committed after and not including commit-id: ccc0d2c5f9a5ac661e60e6eaf138de7889928b8b
 * are released under the following license:
 *
 * This file is part of Hopsworks
 * Copyright (C) 2018, Logical Clocks AB. All rights reserved
 *
 * Hopsworks is free software: you can redistribute it and/or modify it under the terms of
 * the GNU Affero General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * Hopsworks is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE.  See the GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License along with this program.
 * If not, see <https://www.gnu.org/licenses/>.
 *
 * Changes to this file committed before and including commit-id: ccc0d2c5f9a5ac661e60e6eaf138de7889928b8b
 * are released under the following license:
 *
 * Copyright (C) 2013 - 2018, Logical Clocks AB and RISE SICS AB. All rights reserved
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this
 * software and associated documentation files (the "Software"), to deal in the Software
 * without restriction, including without limitation the rights to use, copy, modify, merge,
 * publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS  OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL  THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR  OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package io.hops.hopsworks.api.util;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class JsonResponse {

  private static final float version = 1.0f;

  private String status;
  private Integer statusCode;
  private String errorMsg = "";
  private String successMessage;
  private String QRCode;
  private List<String> fieldErrors;
  private Object data;
  private String sessionID;

  public JsonResponse() {
  }

  public JsonResponse(String status) {
    this.status = status;
  }

  public JsonResponse(Integer statusCode) {
    this.statusCode = statusCode;
  }

  public Integer getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(Integer statusCode) {
    this.statusCode = statusCode;
  }

  @XmlElement
  public float getVersion() {
    return JsonResponse.version;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @XmlElement
  public String getErrorMsg() {
    return errorMsg;
  }

  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }

  public String getSuccessMessage() {
    return successMessage;
  }

  public void setSuccessMessage(String successMessage) {
    this.successMessage = successMessage;
  }

  public List<String> getFieldErrors() {
    return fieldErrors;
  }

  public void setFieldErrors(List<String> fieldErrors) {
    this.fieldErrors = fieldErrors;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  @XmlElement
  public String getSessionID() {
    return sessionID;
  }

  public void setSessionID(String sessionID) {
    this.sessionID = sessionID;
  }

  public String getQRCode() {
    return QRCode;
  }

  public void setQRCode(String QRCode) {
    this.QRCode = QRCode;
  }

}
