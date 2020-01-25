import os
import requests
import argparse
import subprocess
from aria2_rpc.Aria2 import Aria2RPC

# def merge(self, binaries): # Generic command for merging subtitles with video
#     command = binaries + 'ffmpeg -i "%s" -acodec libvo_aacenc -b:a 128k -ac 2 -vcodec libx264 %s "%s"'
#     # Process all the files in target directory
#     for root, dirs, files in os.walk(self.target()):
#         for name in files:
#             # Process only video files
#             if self.video(name):
#                 original = name
#                 # Go to the directory where the file is located
#                 os.chdir(root)
#                 # Extract the name of the file without the extension
#                 name = name[:-4]
#                 # Assume the subtitles have the same name as the video file
#                 subtitles = name + '.srt'
#                 # Get rid of quote characters
#                 os.rename(original, self.simplify(original))
#                 original = self.simplify(original)
#                 merged = self.simplify(name) + '.srt.mp4'
#                 # Expand the command if subtitles are present (UTF-8 is assumed)
#                 if os.path.exists(subtitles):
#                     os.rename(subtitles, self.simplify(subtitles))
#                     subtitles = self.simplify(subtitles)
#                     subtitles = '-vf subtitles="%s"' % subtitles
#                 else:
#                     subtitles = ''
#                 # Run the conversion/merger
#                 os.system(command % (original, subtitles, merged))


class Main(object):
    def __init__(self, api, api_prefix, dest):
        self.api = api
        self.api_prefix = api_prefix
        self.url_list = []
        self.dest = dest

    def download(self):
        # jsonrpc = Aria2RPC(host="http://localhost", port=6800)
        # jsonrpc.addUri(self.url_list, {})
        subprocess.call("aria2c -i {0} -d {1}".format(
            os.path.join(self.dest, "url_list.txt"), self.dest))

    def merge(self):
        pass

    def parse(self):
        try:
            res = requests.get(self.api)
            for i in res.text.splitlines():
                if i.startswith("#"):
                    continue
                else:
                    self.url_list.append(self.api_prefix + i)

            self.save_urls()
        except Exception as e:
            print(e)

    def save_urls(self):
        if not os.path.exists(self.video_path):
            os.mkdir(self.video_path)
        with open(os.path.join(self.video_path, "url_list.txt"), "w") as f:
            for i in self.url_list:
                f.write(i + "\n")


if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument('--api', help="API url that will be parsed")
    parser.add_argument('--api-prefix', help="url prefix")
    parser.add_argument('--dest', help="location urls are stored")
    args = parser.parse_args()
    main = Main(args.api, args.api_prefix, args.dest)
    main.parse()
