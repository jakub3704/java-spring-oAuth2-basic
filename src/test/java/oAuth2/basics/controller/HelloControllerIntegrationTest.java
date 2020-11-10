/****************************************************************************
 * Copyright 2020 Jakub Koczur
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, 
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES  
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. 
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,  
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 *****************************************************************************/

package oAuth2.basics.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import oAuth2.basics.security.MockAccessTokenService;

@AutoConfigureMockMvc
@WebAppConfiguration
@ActiveProfiles("default")
@SpringBootTest
public class HelloControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;
       
    @Test
    public void getHelloMessageForAdminTest() throws Exception{
        MockAccessTokenService mockAccessTokenService = new MockAccessTokenService();
        String accessToken = mockAccessTokenService.obtainAccessToken("admin", "adminp", mvc);

        ResultActions result = mvc
                .perform(MockMvcRequestBuilders.get("/hello/admin")
                        .header("Content-Type", "application/json;charset=UTF-8")
                        .header("Access-Control-Allow-Origin", "*")
                        .header("Authorization", "Bearer " + accessToken));

        result.andExpect(status().isOk())
              .andExpect(content().string("Hello Master!"));      
    }
   
    @Test
    public void getHelloMessageForUserTest() throws Exception{
        MockAccessTokenService mockAccessTokenService = new MockAccessTokenService();
        String accessToken = mockAccessTokenService.obtainAccessToken("user", "userp", mvc);

        ResultActions result = mvc
                .perform(MockMvcRequestBuilders.get("/hello/user")
                        .header("Content-Type", "application/json;charset=UTF-8")
                        .header("Access-Control-Allow-Origin", "*")
                        .header("Authorization", "Bearer " + accessToken));

        result.andExpect(status().isOk())
              .andExpect(content().string("User huh..."));  
    }
    
    @Test
    public void getHelloMessageTest() throws Exception{
        MockAccessTokenService mockAccessTokenService = new MockAccessTokenService();
        String accessToken = mockAccessTokenService.obtainAccessToken("user", "userp", mvc);

        ResultActions result = mvc
                .perform(MockMvcRequestBuilders.get("/hello")
                        .header("Content-Type", "application/json;charset=UTF-8")
                        .header("Access-Control-Allow-Origin", "*")
                        .header("Authorization", "Bearer " + accessToken));

        result.andExpect(status().isOk())
              .andExpect(content().string("Hello!"));
    }
    
    @Test
    public void getHelloMessageTest_notAuthorized() throws Exception{
        ResultActions result = mvc
                .perform(MockMvcRequestBuilders.get("/hello"));

        result.andExpect(status().is(401));
    }
    
    @Test
    public void getHelloMessageWorldTest() throws Exception{
        ResultActions result = mvc.perform(MockMvcRequestBuilders.get("/hello/world"));
        
        result.andExpect(status().isOk())
            .andExpect(content().string("Hello World!"));
    } 
}
