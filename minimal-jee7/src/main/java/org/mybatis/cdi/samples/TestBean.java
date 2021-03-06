/**
 *    Copyright 2013-2017 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.cdi.samples;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Sample Bean using a Mapper.
 * @author Frank D. Martinez M. [mnesarco], Jan 27, 2017
 */
@RequestScoped
@Named("testBean")
public class TestBean {

  @Inject
  UserMapper userMapper;
  
  @Inject
  SampleStatefulBean stateful;
  
  @Inject
  SampleStatelessBean stateless;
  
  public User getUser() {
    return userMapper.getUser(1);
  }
  
  public User getUserFromStateless() {
    return stateless.findUser(1);
  }
    
  public User getUserFromStateful() {
    return stateful.findUser(1);
  }
    
}
