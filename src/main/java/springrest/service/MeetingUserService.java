//package springrest.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import springrest.entity.MeetingUser;
//import springrest.repository.MeetingUserRepository;
//import springrest.repository.UserRepository;
//import springrest.entity.User;
//
//@Service
//public class MeetingUserService {
//	
//	@Autowired
//	private MeetingUserRepository meetingUserRepository;
//	@Autowired
//	private UserRepository userRepository;
//	
////	@Autowired
////	public MeetingUserService(MeetingUserRepository meetingUserRepository, UserRepository userRepository) {
////		this.meetingUserRepository = meetingUserRepository;
////		this.userRepository = userRepository;
////	}
//
//	public List<User> getParticipants(int id) {
//		
//		List<MeetingUser> meetingUserList = meetingUserRepository.findByIdMeeting(id);
//		List<User> users = new ArrayList<>();
//
//		for (MeetingUser tempMeetingUser : meetingUserList) {
//			users.add(userRepository.findById(tempMeetingUser.getIdUser()));
//		}
//		return users;
//	}
//
//	public List<MeetingUser> getMeetingsForUser(int id) {
//		return meetingUserRepository.findByIdUser(id);
//	}
//
//	public void signUp(User user, int meetingId) {
//		meetingUserRepository.save(new MeetingUser(user.getId(), meetingId));
//	}
//
//	public void signOut(User user, int meetingId) {
//		meetingUserRepository.deleteByIdUserAndIdMeeting(user.getId(), meetingId);
//	}
//
//}
