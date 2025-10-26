public class Job {
    private String owner;
    private int jobID;

    public Job(String owner, int jobID) {
        this.owner = owner;
        this.jobID = jobID;
    }
    public String getOwner() {
        return owner;
    }
    public int getJobId() {
        return jobID;
    }

    public String toString() { return owner + ": " + jobID; }

}
