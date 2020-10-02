""" My name is Fran Sabetpour and this is the script for P11: Browsing the Web. """

import urllib.request
import urllib.parse
import re

def browsing_web():
    try:
        url = input("Including either http:// or https://, enter a URL to count the number of links: ")
        feedback = ""
    except:
        print ("Invalid URL.")
        return
    try:
        request = urllib.request.Request(url, headers = {"User-Agent": "Mozilla/5.0"})
        feedback = urllib.request.urlopen(request)
    except Exception as e:
        print("Unable to open web page.")
        return
    link_list = []
    webpage = feedback.read().decode(feedback.headers.get_content_charset())
    lines = webpage.split('\n')
    for line in lines:
        lowercase = line.lower()
        link_search_https = re.findall(r'.*href\=.*(http|https\:.+)\"',lowercase)
        if len(link_search_https) > 0:
            for i in link_search_https:
                if i not in link_list:
                    link_list.append(i)
    print("Number of weblinks: ", len(link_list))

        
if __name__ == '__main__':
    browsing_web()
    while True:
        tryagain = input("Would you like to try again? Press 'Y' for yes or 'N' for no. ")
        if tryagain.lower() != "y":
            print("Exiting the program.")
            quit()
        else:
            browsing_web()