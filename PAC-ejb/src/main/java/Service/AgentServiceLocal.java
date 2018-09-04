package Service;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import entities.Agent;
import entities.Site;

@Local
public interface AgentServiceLocal {
	public List<Agent> getAllAgent();
	public void deleteAgentByMatricule(String matricule);
	public void deleteAgentById(int id);
	public void updateAgent(Agent agent);
	public Agent getAgentByMat(String matricule);
	public Agent getAgentById(int id);
	public void addAgent(Agent a);
	public void removeAgent(Agent a);
	public List<Agent> findAgentNotAffected(Date date);
}
