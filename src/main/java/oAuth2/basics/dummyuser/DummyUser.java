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

package oAuth2.basics.dummyuser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class DummyUser {
	String username;
	String password;
	List<SimpleGrantedAuthority> auth = new ArrayList<>();

	public DummyUser(String username, String password, List<SimpleGrantedAuthority> auth) {
		this.username = username;
		this.password = password;
		this.auth = auth;
	}

	public User toUser() {
		return new User(username, password, true, true, true, true, auth);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<SimpleGrantedAuthority> getAuth() {
		return auth;
	}

	public void setAuth(List<SimpleGrantedAuthority> auth) {
		this.auth = auth;
	}
}
