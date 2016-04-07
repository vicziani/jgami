package jgami.courses.backend;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface BadgeRepository extends JpaRepository<Badge, UUID> {
    List<Badge> findByIssuedAtIsNull();

    List<Badge> findByIssuedAtIsNotNull();
}
