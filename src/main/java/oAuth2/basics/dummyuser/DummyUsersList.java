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
import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

public class DummyUsersList {

	List<DummyUser> users = new ArrayList<>();

	public DummyUsersList(PasswordEncoder passwordEncoder) {
		createTestUsers(passwordEncoder);
	}

	private void createTestUsers(PasswordEncoder passwordEncoder) {
		if (users.isEmpty()) {
			users.add(new DummyUser("admin", passwordEncoder.encode("adminp"),
			        Arrays.asList(new SimpleGrantedAuthority("ADMIN"))));
			users.add(new DummyUser("user", passwordEncoder.encode("userp"),
			        Arrays.asList(new SimpleGrantedAuthority("USER"))));
		}
	}

	public DummyUser findUser(String username) {
		for (DummyUser user : users) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}

}
