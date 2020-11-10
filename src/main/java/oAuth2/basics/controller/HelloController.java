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

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/admin")
    public String getHelloMessageForAdmin() {
        return "Hello Master!";
    }

    @GetMapping("/user")
    public String getHelloMessageForUser() {
        return "User huh...";
    }

    @GetMapping
    public String getHelloMessage() {
        return "Hello!";
    }

    @GetMapping("/world")
    public String getHelloMessageWorld() {
        return "Hello World!";
    }
}
