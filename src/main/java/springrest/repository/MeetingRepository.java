package springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springrest.entity.Meeting;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Integer> {


}
