#!/bin/bash

LOG_DIR="Spring-Hello-Log4j/logs"
ARCHIVE_DIR="Spring-Hello-Log4j/logs/archive"

# Ensure the archive directory exists
mkdir -p "$ARCHIVE_DIR"

# Find and compress log files older than a day
find "$LOG_DIR" -type f -name "application.log" -mtime +1 -exec gzip {} \;

# Move compressed logs to the archive directory
find "$LOG_DIR" -type f -name "application.log.gz" -exec mv {} "$ARCHIVE_DIR" \;

# Optionally, remove old archive logs (e.g., older than 3 days)
find "$ARCHIVE_DIR" -type f -name "application.log.gz" -mtime +3 -exec rm {} \;
