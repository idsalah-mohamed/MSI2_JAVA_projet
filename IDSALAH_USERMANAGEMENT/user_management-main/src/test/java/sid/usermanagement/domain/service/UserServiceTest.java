package sid.usermanagement.domain.service;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import sid.usermanagement.UnitTest;
import sid.usermanagement.model.data.User;
import sid.usermanagement.model.repository.UserRepo;
import sid.usermanagement.domain.data.UserD;
import sid.usermanagement.domain.data.UserR;
import sid.usermanagement.domain.service.implement.UserServiceImpl;
import sid.usermanagement.domain.service.map.UserMap;

class UserServiceTest extends UnitTest {

    @Mock
    private UserRepo userRepo;
    
    private UserService userService;
    
    private UserD userD;
    private User user;
    
    @Override
	protected void setup() {
		userService = new UserServiceImpl(userRepo);
		this.userD = random.nextObject(UserD.class);
		this.user = UserMap.mapToEntity(userD);
	}
    
    @Test
    public void testCreateUser()  {
    	when(userRepo.save(user)).thenReturn(user);  
    	UserD secondUserD = userService.createUser(userD);
        assertNotNull(userRepo);
        assertNotNull(secondUserD);
        Assertions.assertThat(userD.getFullName()).isEqualTo(secondUserD.getFullName());
        
    }

    @Test
    public void testGetAll()  {
    	List<User> users = new ArrayList<User>();
    	users.add(user);
    	PageImpl<User> pageUsers = new PageImpl<User>(users);
    	
        when(userRepo.findAll(Mockito.any(Pageable.class))).thenReturn(pageUsers);  
        UserR response = userService.getAllUsers(0, 10, "id", "asc");
        assertNotNull(response);
        Assertions.assertThat(response.getContent().size()).isEqualTo(1);
        Assertions.assertThat(response.getContent().get(0).getFullName()).isEqualTo(userD.getFullName());
    }

	
}
