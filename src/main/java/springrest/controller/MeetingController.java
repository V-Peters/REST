package springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springrest.entity.Meeting;
import springrest.service.MeetingService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/meeting")
public class MeetingController {
	
	@Autowired
	private MeetingService meetingService;
	
	@GetMapping("/list")
	public List<Meeting> listMeetings() {
		return meetingService.getMeetings();
	}
	
}
