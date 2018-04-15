package es.model;

public class HealthJSON implements ESable{
    public String cluster_name;
    public String status;
    public boolean timed_out;
    public int number_of_nodes;
    public int number_of_data_nodes;
    public int active_primary_shards;
    public int active_shards;
    public int relocating_shards;
    public int initializing_shards;
    public int unassigned_shards;
    public int delayed_unassigned_shards;
    public int number_of_pending_tasks;
    public int number_of_in_flight_fetch;
    public int task_max_waiting_in_queue_millis;
    public float active_shards_percent_as_number;

    public String getRequest() {
        return "http://localhost:9200/_cluster/health";
    }
}
