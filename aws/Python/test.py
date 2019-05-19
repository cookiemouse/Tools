#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Created by cookiemouse on 2018/1/23
"""

__author__ = 'cookiemouse'

from flask import Flask, abort, request

app = Flask(__name__)


@app.route('/')
def index():
    return app.send_static_file('html/index.html')

@app.route('/xixi')
def xixi():
    return app.send_static_file('html/xixi.html')


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000, debug=False)

