import requests
import re
import base64


def spider(url):
    try:
        response = requests.get(url)
        if response.status_code == 200:
            with open("result.txt", 'w') as r:
                r.write(response.text)
    except Exception as e:
        print(e)


def parse_by_re():
    ss_pattern = re.compile(r'(^\|.*\|[0-9]+\|.*\|.*\|.*\|.*\|$)')
    ssr_pattern = re.compile(r'^\|[0-9]+\|(ssr://[0-9A-Za-z=]+)\|$')
    ss = open("ss.txt", 'w')
    ssr = open("ssr.txt", 'w')
    with open("result.txt", 'r') as f:
        for line in f.readlines():
            if ss_pattern.match(line):
                ss.write(line)
            if ssr_pattern.match(line):
                match_object = ssr_pattern.match(line)
                ssr_string = match_object.group(1)
                ssr.write(ssr_string + '\n')
    ss.close()
    ssr.close()


def generate_link():
    # ssr://server:port:protocol:method:obfs:password_base64/?params_base64
    # ss://method[-auth]:password@hostname:port
    ss_link = open("ss_link.txt", 'w')
    with open("ss.txt", 'r') as ss:
        for line in ss.readlines():
            params = line.split("|")
            config = params[4] + ':' + params[3] + '@' + params[1] + ':' + params[2]
            params_b64 = base64.b64encode(bytes(config, encoding='utf-8'))
            link = 'ss://' + str(params_b64, encoding='utf-8')
            ss_link.write(link + '\n')
    ss_link.close()


if __name__ == '__main__':
    url = "https://raw.githubusercontent.com/dxxzst/Free-SS-SSR/master/README.md"
    spider(url)
    parse_by_re()
    generate_link()
