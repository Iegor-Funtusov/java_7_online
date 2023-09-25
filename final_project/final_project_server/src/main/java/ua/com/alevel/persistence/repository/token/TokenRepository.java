package ua.com.alevel.persistence.repository.token;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.token.Token;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.persistence.repository.BaseRepository;

import java.util.Optional;

@Repository
public interface TokenRepository extends BaseRepository<Token> {

    Optional<Token> findByUser(User user);
    Optional<Token> findByToken(String token);
}
