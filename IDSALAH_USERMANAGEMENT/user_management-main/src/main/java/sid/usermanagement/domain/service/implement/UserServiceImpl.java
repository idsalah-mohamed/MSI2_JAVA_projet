package sid.usermanagement.domain.service.implement;

import sid.usermanagement.domain.service.map.UserMap;
import sid.usermanagement.model.data.User;
import sid.usermanagement.model.repository.UserRepo;
import sid.usermanagement.domain.data.UserD;
import sid.usermanagement.domain.data.UserR;
import sid.usermanagement.domain.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo UserRepo;

    public UserServiceImpl(UserRepo UserRepo) {
          this.UserRepo = UserRepo;
    }

    @Override
    public UserD createUser(UserD userD) {
        // convert DTO to entity
        User user = UserMap.mapToEntity(userD);
        User newUser = UserRepo.save(user);

        // convert entity to DTO
        UserD userResponse = UserMap.mapToDTO(newUser);
        return userResponse;
    }

    @Override
    public UserR getAllUsers(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<User> users = UserRepo.findAll(pageable);

        // get content for page object
        List<User> listOfUsers = users.getContent();

        List<UserD> content= listOfUsers.stream().map(user -> UserMap.mapToDTO(user)).collect(Collectors.toList());

        UserR userR = new UserR();
        userR.setContent(content);
        userR.setPageNo(users.getNumber());
        userR.setPageSize(users.getSize());
        userR.setTotalElements(users.getTotalElements());
        userR.setTotalPages(users.getTotalPages());
        userR.setLast(users.isLast());

        return userR;
    }


}