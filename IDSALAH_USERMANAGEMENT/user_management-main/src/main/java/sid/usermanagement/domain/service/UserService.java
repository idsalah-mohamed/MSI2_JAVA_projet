package sid.usermanagement.domain.service;

import sid.usermanagement.domain.data.UserD;
import sid.usermanagement.domain.data.UserR;

public interface UserService {

    UserD createUser(UserD userD);

    UserR getAllUsers(int pageNo, int pageSize, String sortBy, String sortDir);
}
