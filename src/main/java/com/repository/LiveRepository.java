package com.repository;

import com.model.Live;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface LiveRepository extends JpaRepository<Live, Long> {
    Optional<Live> findByLiveName(String liveName);
}