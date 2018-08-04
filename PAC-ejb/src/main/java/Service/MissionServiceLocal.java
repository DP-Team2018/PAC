package Service;

import java.util.List;

import javax.ejb.Local;

import entities.Mission;

@Local
public interface MissionServiceLocal {
	
	public void addMission(Mission mission);
	public void removeMission(Mission mission);
	public void updateMission(Mission mission);
	public List<Mission> findListMission();
}
