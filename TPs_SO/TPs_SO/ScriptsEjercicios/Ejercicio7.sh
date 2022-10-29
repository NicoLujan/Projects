#!/bin/bash

CIRCULAR_SIZE=3
LOG_PATH=logs

if [ -n "$(find $LOG_PATH -type f -size +1k -iname app_log.out)" ];then

	if [ "$(ls -1 $LOG_PATH | grep .zip | wc -l)" -ge $CIRCULAR_SIZE ];then
		slotToFree="$(ls -1t $LOG_PATH | grep .zip | tail -1)"
		rm $LOG_PATH/$slotToFree
	fi
	
	mostRecent="$(ls -1t $LOG_PATH | grep .zip | head -1 | cut -d"-" -f1)"
	zip -m $LOG_PATH/"$(( mostRecent +1 ))"-app_log.zip $LOG_PATH/app_log.out
fi
