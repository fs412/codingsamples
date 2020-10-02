""" My name is Fran Sabetpour and the purpose of this script is to write a script that reads through a file and prints out the content. It then indicates line by line if the line indicated is valid or not. """
def gedcomfile(path):
    try:
        fp = open(path, "r", encoding="utf-8")
        data = list()
    except FileNotFoundError:
        raise FileNotFoundError("Could not open '{path}' for reading.")

    for line in fp.readlines():
        line = line.strip()
        input = "--> " + line
        print(input)
        data.append(input)
        entry = line.split()
        level = entry[0]

        toplevel = ["HEAD", "TRLR", "NOTE", "INDI", "FAM"]
        misctag = ["NAME", "SEX", "BIRT", "DEAT", "FAMC","FAMS", "MARR", "HUSB", "WIFE", "CHIL", "DIV"]
        datetag = ["DATE"]

        if level == "0":
            if entry[1] in toplevel:
                tag = entry[1]
                valid = "Y"
                argument = " ".join(entry[2:])
                lineforgedcom = "<-- %s|%s|%s|%s" % (level, tag, valid, argument)

            elif entry[2] in toplevel:
                tag = entry[2]
                valid = "Y"
                arguments = entry[1]
                lineforgedcom = "<-- %s|%s|%s|%s" % (level, tag, valid, arguments)

            else:
                tag = entry[1]
                valid = "N"
                argument = " ".join(entry[2:])
                lineforgedcom = "<-- %s|%s|%s|%s" % (level, tag, valid, argument)

        elif level == "1":
            tag = entry[1]
            argument = " ".join(entry[2:])
            if entry[1] in misctag:
                valid = "Y"
            else:
                valid = "N"
            lineforgedcom = "<-- %s|%s|%s|%s" % (level, tag, valid, argument)

        elif level == "2":
            tag = entry[1]
            argument = " ".join(entry[2:])
            if entry[1] in datetag:
                valid = "Y"
            else:
                valid = "N"
            lineforgedcom = "<-- %s|%s|%s|%s" % (level, tag, valid, argument)

        else:
            tag = entry[1]
            valid = "N"
            argument = " ".join(entry[2:])
            lineforgedcom = "<-- %s|%s|%s|%s" % (level, tag, valid, argument)

        print(lineforgedcom)
        data.append(lineforgedcom)


def main():
    franfile = "C:/Users/Fran/Documents/Summer 2019/Project01-FS.ged"
    testfile = "C:/Users/Fran/Documents/Summer 2019/proj02test.ged"
    gedcomfile(franfile)
    print("\n ***This marks the end of the file created by Fran. Here begins the test file.*** \n")
    gedcomfile(testfile)

if __name__ == "__main__":
    main()

