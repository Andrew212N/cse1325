#include <iostream>

int main()
{
    char name[128];
    std::cout << "Enter your name: ";
    std::cin.getline(name, 127);
    std::cout << "Hello " << name << "!" << std::endl;
    return 0;
}
