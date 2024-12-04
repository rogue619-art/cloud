import java.util.ArrayList;
import java.util.List;

public class FirewallSetup {
    static class Rule {
        String sourceIP;
        String destinationIP;
        String action;

        Rule(String sourceIP, String destinationIP, String action) {
            this.sourceIP = sourceIP;
            this.destinationIP = destinationIP;
            this.action = action;
        }

        @Override
        public String toString() {
            return "Rule: [Source=" + sourceIP + ", Destination=" + destinationIP + ", Action=" + action + "]";
        }
    }

    public static void main(String[] args) {
        // Firewall Rules
        List<Rule> firewallRules = new ArrayList<>();

        // Adding rules
        firewallRules.add(new Rule("192.168.1.1", "192.168.1.2", "ALLOW"));
        firewallRules.add(new Rule("192.168.1.3", "192.168.1.4", "DENY"));

        // Display rules
        System.out.println("Firewall Rules:");
        for (Rule rule : firewallRules) {
            System.out.println(rule);
        }

        // Simulate packet filtering
        String incomingSourceIP = "192.168.1.1";
        String incomingDestinationIP = "192.168.1.2";

        boolean isAllowed = firewallRules.stream()
                .anyMatch(rule -> rule.sourceIP.equals(incomingSourceIP)
                        && rule.destinationIP.equals(incomingDestinationIP)
                        && rule.action.equalsIgnoreCase("ALLOW"));

        if (isAllowed) {
            System.out.println("Packet from " + incomingSourceIP + " to " + incomingDestinationIP + " is ALLOWED.");
        } else {
            System.out.println("Packet from " + incomingSourceIP + " to " + incomingDestinationIP + " is BLOCKED.");
        }
    }
}

