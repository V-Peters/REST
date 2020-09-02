//package springrest.repository;
//
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import springrest.entity.MeetingUser;
//
//@Repository
//public interface MeetingUserRepository extends JpaRepository<MeetingUser, Integer> {
//
//	public List<MeetingUser> findByIdUser(int id);
//
//	public MeetingUser findByIdUserAndIdMeeting(int userId, int meetingId);
//
//	public List<MeetingUser> findByIdMeeting(int id);
//
//	@Transactional
//	public void deleteByIdUserAndIdMeeting(int userId, int meetingId);
//
//	public void deleteByIdMeeting(int id);
//
//}
