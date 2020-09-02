//package springrest.controller;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import springrest.entity.Meeting;
//import springrest.entity.User;
//import springrest.helper.Counter;
//import springrest.service.MeetingService;
//import springrest.service.MeetingUserService;
//import springrest.valid_paths.ValidPaths;
//import springrest.constants.Constants;
//
//@Controller
//@RequestMapping("/meetingUser")
//public class MeetingUserController {
//	
//	@Autowired
//	private MeetingUserService meetingUserService;
//	
//	@Autowired
//	private MeetingService meetingService;
//
//	@GetMapping("/listParticipants")
//	public String listMeetings(@RequestParam(Constants.MEETING_ID) int id, Model model, HttpServletRequest request) {
//		
//		if (!this.isUserLoggedIn(request)) {
//			return ValidPaths.REDIRECT_USER_AUTO_LOGOUT.getPath();
//		}
//		
//		Meeting meeting = meetingService.getMeeting(id);
//		
//		if (meeting == null) {
//			return ValidPaths.REDIRECT_ERROR_PARAMETERERROR.getPath();
//		}
//		
//		List<User> participants = meetingUserService.getParticipants(id);
//
//		model.addAttribute("counter", new Counter());
//		model.addAttribute("meeting", meeting);
//		model.addAttribute("participants", participants);
//		
//		return ValidPaths.MEETINGUSER_LIST_PARTICIPANTS.getPath();
//	}
//	
//	@GetMapping("/signUp")
//	public String signUp(@RequestParam(Constants.MEETING_ID) int meetingId, HttpServletRequest request) {
//		
//		if (!this.isUserLoggedIn(request)) {
//			return ValidPaths.REDIRECT_USER_AUTO_LOGOUT.getPath();
//		}
//		
//		if (meetingService.getMeeting(meetingId) == null) {
//			return ValidPaths.REDIRECT_ERROR_PARAMETERERROR.getPath();
//		}
//		
//		User userId = (User)request.getSession().getAttribute("user");
//		
//		meetingUserService.signOut(userId, meetingId);
//		meetingUserService.signUp(userId, meetingId);
//		
//		return ValidPaths.REDIRECT_MEETING_LIST.getPath();
//	}
//	
//	@GetMapping("/signOut")
//	public String signOut(@RequestParam(Constants.MEETING_ID) int meetingId, HttpServletRequest request) {
//		
//		if (!this.isUserLoggedIn(request)) {
//			return ValidPaths.REDIRECT_USER_AUTO_LOGOUT.getPath();
//		}
//		
//		meetingUserService.signOut((User)request.getSession().getAttribute("user"), meetingId);
//		
//		return ValidPaths.REDIRECT_MEETING_LIST.getPath();
//	}
//	
//	private boolean isUserLoggedIn(HttpServletRequest request) {
//		return request.getSession().getAttribute("user") != null;
//	}
//	
//	
//}
