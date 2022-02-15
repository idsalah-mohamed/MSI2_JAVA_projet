package sid.usermanagement.domain.service.map;

import sid.usermanagement.model.data.User;
import sid.usermanagement.domain.data.UserD;

public class UserMap {

    // convert Entity into DTO
    public static UserD mapToDTO(User user){
        UserD userD = new UserD();
        userD.setId(user.getId());
        userD.setFullName(user.getFullName());
        userD.setEmail(user.getEmail());
        return userD;
    }

    // convert DTO to entity
    public static User mapToEntity(UserD userD){
        User user = new User();
        user.setFullName(userD.getFullName());
        user.setEmail(userD.getEmail());
        return user;
    }
}
