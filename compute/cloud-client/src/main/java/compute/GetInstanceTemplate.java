/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package compute;

import com.google.cloud.compute.v1.GetInstanceTemplateRequest;
import com.google.cloud.compute.v1.InstanceTemplate;
import com.google.cloud.compute.v1.InstanceTemplatesClient;
import java.io.IOException;

public class GetInstanceTemplate {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    // projectId: project ID or project number of the Cloud project you use.
    // templateName: name of the new template to retrieve.
    String projectId = "your-project-id";
    String templateName = "template-name";
    getInstanceTemplate(projectId, templateName);
  }

  //  Retrieve an instance template, which you can use to create virtual machine
  //  (VM) instances and managed instance groups (MIGs).
  public static void getInstanceTemplate(String projectId, String templateName) throws IOException {
    try (InstanceTemplatesClient instanceTemplatesClient = InstanceTemplatesClient.create()) {

      GetInstanceTemplateRequest getInstanceTemplateRequest = GetInstanceTemplateRequest
          .newBuilder()
          .setProject(projectId)
          .setInstanceTemplate(templateName).build();

      InstanceTemplate instanceTemplate = instanceTemplatesClient.get(getInstanceTemplateRequest);
      System.out.println("Instance Template retrieved: " + instanceTemplate.getName());
    }
  }
}
