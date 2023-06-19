//#include <>

class Human {
    string name;
    int * ageFunc = getSome();
    int age = &ageFunc;
}

int getSome() {
    return 0;
}
