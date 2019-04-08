cmake_minimum_required(VERSION 3.9)
project(asn)

set(CMAKE_CXX_STANDARD 11)

add_executable(asn
        tests/run.sh
        tests/test1.txt
        tests/test2.txt
        execute.c
        execute.h
        helper.c
        helper.h
        job.c
        job.h
        linked_list.c
        linked_list.h
        linked_stack.c
        linked_stack.h
        myOS.c
        myOS.h
        shell.c
        shell.h
        simulate.c
        simulate.h
        simulator.c
        simulator.h
        tokenize.c
        tokenize.h run.c run.h)
