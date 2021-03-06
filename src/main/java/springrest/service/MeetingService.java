package springrest.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

	public Meeting getMeeting(int id) {
		
		Optional<Meeting> tempMeeting = meetingRepository.findById(id);
		
		Meeting meeting = null;
		
		if (tempMeeting.isPresent()) {
			meeting = tempMeeting.get();
		}
		
		return meeting;
	}

	public void saveMeeting(Meeting meeting) {
		meeting.setLastUpdated(LocalDateTime.now());
		meetingRepository.save(meeting);
	}


	public void deleteMeeting(int meetingId) {
		System.out.println("delete in service");
		this.meetingRepository.deleteById(meetingId);
	}

}