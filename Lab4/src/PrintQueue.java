/**
 * Antony Punnassery
 * B01012905
 */
public class PrintQueue {
    private GenericQueue<Job> queue;

    public PrintQueue() {
        queue = new GenericQueue<>();
    }

    // Enqueues a Job with the specified owner name and job id
    public void lpr(String owner, int jobId) {
        Job job = new Job(owner, jobId);
        queue.enqueue(job);
    }

    // Prints all the entries in this Queue
    public void lpq() {
        if (queue.isEmpty()) {
            System.out.println("Queue:");
            return;
        }

        System.out.print("Queue: ");
        for (int i = 0; i < queue.size(); i++) {
            Job job = queue.peek();
            System.out.print(job);
            if (i < queue.size() - 1) {
                System.out.print(" ");
            }
            // Rotate to see next element
            queue.enqueue(queue.dequeue());
        }
        System.out.println();
    }

    // Removes the active job at the front of the Queue if jobId matches
    public void lprm(int jobId) {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        Job frontJob = queue.peek();
        if (frontJob.getJobId() == jobId) {
            queue.dequeue();
            System.out.println("Removed active job " + jobId);
        } else {
            System.out.println("Active job id does not match " + jobId + "; nothing removed");
        }
    }

    // Removes all jobs from the Queue that have been submitted by the owner
    public void lprmAll(String owner) {
        int count = 0;
        int originalSize = queue.size();

        for (int i = 0; i < originalSize; i++) {
            Job job = queue.dequeue();
            if (!job.getOwner().equals(owner)) {
                queue.enqueue(job);
            } else {
                count++;
            }
        }

        System.out.println("Removed " + count + " job(s) owned by " + owner);
    }
}
