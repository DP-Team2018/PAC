package Service;

import java.util.List;

import javax.ejb.Remote;

import entities.Agent;

@Remote
public interface AgentServiceRemote {
	public List<Agent> getAllAgent();
	public void deleteAgentByMatricule(String matricule);
	public void deleteAgentById(int id);
	public void updateAgent(Agent agent);
	public Agent getAgentByMat(String matricule);
	public Agent getAgentById(int id);
	public void addAgent(Agent a);
}
