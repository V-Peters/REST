package springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springrest.entity.Meeting;
import springrest.repository.MeetingRepository;

@Service
public class MeetingService {
	
	@Autowired
	private MeetingRepository meetingRepository;

	
	public List<Meeting> getMeetings() {
		return meetingRepository.findAll();
	}


	public void deleteMeeting(int meetingId) {
		System.out.println("delete in service");
		this.meetingRepository.deleteById(meetingId);
	}

}
