# Network Subnet Calculator

A robust, command-line-based Java utility designed to simplify IPv4 subnetting calculations, CIDR conversions, and network address validation.

---

## Directory Structure

The project uses a structured package layout (`Project.tuts`):

```text
Network_Subnet_Calculator/
│
├── bin/                      # Compiled class files directory
└── Project/
    └── tuts/
        ├── Main.java         # CLI interface and user input handling
        ├── NetCalculator.java# Core subnet math and network logic
        ├── ip_inclusion.trial
        ├── subnet_algo.trial
        └── progressbar.trial
```

---

## Features

1. **Network Requirement Mode (Mode 1):** 
   - Takes a desired number of subnets, calculates the required subnet bits, derives the new CIDR notation, and computes total IPs and usable hosts per subnet.
2. **Host Requirement Mode (Mode 2):**
   - **With IP Validation:** Supports Class B (`172.16.xx.xx`) and Class C (`192.168.xx.xx`) networks. Validates whether an entered network address aligns with the given CIDR mask before calculating ranges.
   - **Without IP:** Calculates required host bits, total block size, usable host counts ($2^h - 2$), CIDR prefix, and subnet masks based strictly on host demand.
3. **Robust Input Handling:**
   - Gracefully manages menu validation and prevents infinite loops on invalid or non-integer inputs.

---

## Compilation & Execution

Since the repository includes trial files alongside the core source code, you only need to compile `Main.java` and `NetCalculator.java`.

### 1. Compile the Project
Open your terminal in the root repository directory and run:

```bash
javac -d bin Project/tuts/Main.java Project/tuts/NetCalculator.java
```

### 2. Run the Application
Execute the compiled main class using the classpath flag:

```bash
java -cp bin Project.tuts.Main
```
