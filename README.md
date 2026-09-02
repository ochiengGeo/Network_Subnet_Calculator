# Network Subnet Calculator

A lightweight Java command-line utility designed to perform subnetting calculations, estimate host space overhead, determine block sizes, and convert requirements into standard CIDR notation.

## Features

* **Host Requirements Calculation:** Computes required host bits including subnet overhead (+2 for network and broadcast addresses).
* **CIDR Notation Conversion:** Translates host space demands directly into CIDR prefix lengths.
* **Block Size Increment:** Determines the subnet increment value for simple network boundary planning.
* **Interactive CLI:** Interactive menu system for custom input evaluation.

## File Structure

```text
Network_Subnet_Calculator/
├── Project/
│   └── tuts/
│       └── Desktop/
│           ├── Main.java          # Program entry point and menu handler
│           └── NetCalculator.java # Core subnetting and CIDR calculation logic
├── progressbar.java               # UI helper class
└── README.md
