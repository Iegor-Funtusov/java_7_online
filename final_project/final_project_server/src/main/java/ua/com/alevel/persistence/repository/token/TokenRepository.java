package ua.com.alevel.persistence.repository.token;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.token.Token;
import ua.com.alevel.persistence.repository.BaseRepository;

@Repository
public interface TokenRepository extends BaseRepository<Token> { }
