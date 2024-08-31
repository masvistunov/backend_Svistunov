package t1.debute.techradar.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import t1.debute.techradar.entity.Tech;

import java.util.List;
import java.util.Optional;

@Repository
public interface TechRadarRepository extends CrudRepository<Tech,Integer> {
    List<Tech> findAllByLabelLikeIgnoreCase(String filter);

    Optional<Tech> findFirstByLabelLikeIgnoreCase(String filter);

    List<Tech> findAllByDepartamentLikeIgnoreCase(String filter);

    @Modifying
    @Transactional
    @Query(value = "BACKUP TO ?1", nativeQuery = true)
    int backupDB(String path);
}