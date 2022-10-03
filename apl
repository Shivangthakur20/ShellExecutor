#!/bin/bash


COOKIE_FILE='cookie.test'; #$(mktemp);
TEMP_WORKING_FILE='test.out'; #$(mktemp);
COMMA='%2C';
CONT=1;
if [ ! -f $COOKIE_FILE ]; then
	echo 'You will need to rerun this in order for it to work';
	CONT=0;
fi
CONTAINERS=$(echo $1 $2 $3|xargs|sed -e s/' '/"$COMMA"/g);
echo $CONTAINERS;
curl 'https://www.apl.com/ebusiness/tracking/search' \
  -H 'authority: www.apl.com' \
  -H 'accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9' \
  -H 'accept-language: en-US,en;q=0.9,de;q=0.8' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/x-www-form-urlencoded' \
  -H 'origin: https://www.apl.com' \
  -H 'pragma: no-cache' \
  -H 'referer: https://www.apl.com/ebusiness/tracking' \
  -H 'sec-ch-device-memory: 8' \
  -H 'sec-ch-ua: "Google Chrome";v="105", "Not)A;Brand";v="8", "Chromium";v="105"' \
  -H 'sec-ch-ua-arch: "x86"' \
  -H 'sec-ch-ua-full-version-list: "Google Chrome";v="105.0.5195.126", "Not)A;Brand";v="8.0.0.0", "Chromium";v="105.0.5195.126"' \
  -H 'sec-ch-ua-mobile: ?0' \
  -H 'sec-ch-ua-model: ""' \
  -H 'sec-ch-ua-platform: "Windows"' \
  -H 'sec-fetch-dest: document' \
  -H 'sec-fetch-mode: navigate' \
  -H 'sec-fetch-site: same-origin' \
  -H 'sec-fetch-user: ?1' \
  -H 'sec-gpc: 1' \
  -H 'upgrade-insecure-requests: 1' \
  -H 'user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36' \
  --data-raw 'g-recaptcha-response=&SearchViewModel.SearchBy=Container&SearchViewModel.Reference='$CONTAINERS'&SearchViewModel.FromHome=true&search=' \
  --compressed \
  -c $COOKIE_FILE -b $COOKIE_FILE \
  > $TEMP_WORKING_FILE;


tail -$TAIL $TEMP_WORKING_FILE|head -$HEAD > test.out.html