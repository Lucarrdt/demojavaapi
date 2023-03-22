package Repository;

import Data.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {
    UsersEntity findById(int id);
    UsersEntity findByName(String name);
}
