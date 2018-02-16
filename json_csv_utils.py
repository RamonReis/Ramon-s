import os, sys, inspect
import json
import csv
import boto3
from io import StringIO

def parse_json_file_to_list(local_file_path):
    f = open(local_file_path)
    try:
        result = json.load(f)
        return result
    except ValueError as e:
        f.seek(0)
        data = f.read()

        #the following two lines are for adapting the json file to be read properly
        data = fix_json_str(data)
        
        new_json = StringIO( data )
        result = json.load(new_json)
        new_json.close()
        return result
    finally:
        f.close()

def fix_json_str(json_str,delimiter=','):
    json_str = '[\n' + json_str + ']'
    return json_str.replace(delimiter+'\n', '\n').replace('}\n{', '}' + delimiter + '\n{')

def parse_csv_to_dict_list(csv_file_path, csv_delimeter):
    #Have in mind that the csv file must have a column header
    csvfile = open(csv_file_path, 'r')
    if os.path.getsize(csv_file_path) < 1:
        print(csv_file_path + ' is an empty file')

    field_names = tuple( csvfile.readline().replace('\n','').split(csv_delimeter) )
    reader = csv.DictReader( csvfile, field_names )
    lst = []
    for row in reader:
        lst.append(row)
    csvfile.close()
    #Returns a list of dictionaries
    return lst

def parse_json_str_to_csv_str(json_input_file, delimiter=','):
    input_file = json.loads(json_input_file)
    header = delimiter.join(input_file[0].keys())

    output_str = ''
    count = 0

    for item in input_file:
        if count == 0:
            output_str = output_str + header + "\n"
            count += 1
        for v in item.values():
            output_str = output_str + str(v) + delimiter
        output_str = output_str[0:-1] #Remove the last delimeter of each line
        output_str = output_str + "\n"
    return output_str

def get_values_from_dict_list(dict_list):
    values = []
    for i in dict_list:
        values.append(i.values())

    return values

def load_s3_object_data(s3_bucket='', s3_object_key=''):
    s3 = boto3.resource('s3')
    s3_object_data = s3.Object(s3_bucket, s3_object_key).get()['Body'].read().decode("utf-8")

    result = []
    if 'json' in s3_object_key.lower():
        try:
            return json.load( StringIO(s3_object_data) )
        except ValueError as e:
            for item in s3_object_data.split('\n'):
                if item == '' or item == '\n':
                    continue
                result.append(json.loads(item) )
        return result

def str_to_json(data):
    """Use this method passing a string and returning a JSON format as a list of dicts"""
    try:
        return json.load(StringIO(data))
    except:
        raise Exception("Your JSON are not properly formatted")

def parse_csv_str_to_matrix(csv_str, delimiter=','):
    csv_rows = csv_str.split('\n')
    csv_matrix = []
    for row in csv_rows:
        csv_matrix.append(row.split(delimiter))
    return csv_matrix

def parse_matrix_to_csv_str(csv_matrix, delimiter=','):
    csv_str = ''
    for row in csv_matrix:
        for value in row:
            csv_str = csv_str + str(value) + delimiter
        csv_str = csv_str[:-1] + '\n' #Remove the last delimiter in row and add line break
    csv_str = csv_str[:-1] #Remove the last line break
    return csv_str

def gen_csv_file(header, data, filename, mode_file='w', include_header=True):
    cnt=len(data)
    counter=1
    delm='|'
    with open(filename, mode_file) as out_file:
        if include_header:
            for header in header:
                if counter < cnt:
                    deml='|'
                elif counter >= cnt:
                    deml=''
                out_file.write(header['name'] + deml)
                counter= counter + 1
        for row in data:
            out_file.write('\n')
            for column in row:
                column = column if (column is not None) else 'None'
                out_file.write(str(column) + delm)
    out_file.close()
