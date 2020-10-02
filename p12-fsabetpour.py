""" My name is Fran Sabetpour and this is the script for P12: Using Web API's and JSON. """

import urllib.request
import json
import requests
from math import radians, cos, sin, asin, sqrt

def geocoder(address, benchmark = "Public_AR_Current", vintage = "ACS2018_Current"):
	urllink = "http://geocoding.geo.census.gov/geocoder/geographies/address"
	parameter = {"street":address["street"], "city":address["city"], "state":address["state"], "benchmark":benchmark, "vintage":vintage, "format":"json"}
	info = requests.get(urllink, params=parameter).text
	info = json.loads(info)
	try:
		xcoordinate = info["result"]["addressMatches"][0]["coordinates"]["x"]
		ycoordinate = info["result"]["addressMatches"][0]["coordinates"]["y"]
	except:
		xcoordinate = "Not valid."
		ycoordinate = "Not valid."
	return xcoordinate, ycoordinate

def distance_calculated(location1, location2):
    latitude1,longitude1 = location1
    latitude2,longitude2 = location2
    latitude1 = latitude1 * 0.017453293
    latitude2 = latitude2 * 0.017453293
    longitude1 = longitude1 * 0.017453293
    longitude2 = longitude2 * 0.017453293
    dlongitude = longitude2 - longitude1
    dlatitude = latitude2 - latitude1
    a = sin(dlatitude / 2) ** 2 + cos(latitude1) * cos(latitude2) * sin(dlongitude / 2) ** 2
    c = 2 * asin(min(1, sqrt(a)))
    kilometers = 6367 * c
    miles = (kilometers * 5) / 8
    return miles

def user_input():
    print("Hello, let's calculate the distance of your home to the White House in miles. Please enter your home address starting with the street.")
    try:
        street = input("Enter a valid street: ")
        city = input("Enter city/town: ")
        state = input("Enter state abbreviation: ")
        user_address = {}
        white_house = {"street":"1600 Pennsylvania Avenue NW","city":"Washington","state":"DC"}
        user_address["street"] = street
        user_address["city"] = city
        user_address["state"] = state
        white_house_location = geocoder(white_house)
        user_location = geocoder(user_address)
        distance = round(distance_calculated(user_location, white_house_location))
    except:
        print("Please enter a valid US address.")
        return
    print("The distance between my home and the White house is about {} miles. ".format(distance))

if __name__ == "__main__":
    user_input()
    while True:
        tryagain = input("Would you like to try again? Press 'Y' for yes or 'N' for no. ")
        if tryagain.lower() != "y":
            print("Exiting the program.")
            quit()
        else:
            user_input()

