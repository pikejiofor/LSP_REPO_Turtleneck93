Precious Ikejiofor
Professor Woolfolk
CSCI 363
19 March 2026

CRC Card Delegation Explanation

TaskManager collaborates with Task because TaskManager needs to store tasks, find them, and get them by status. To do all of that, TaskManager has to call methods on Task objects to get their taskId and status information. Task does not collaborate with TaskManager because Task only needs to worry about itself. It stores its own information and updates its own status, so it doesn't need to know anything about the TaskManager that holds it. This follows good design where objects only know about things they actually need.