#include "Matrix3.h"

class Matrix3
{
    public:
        int data1[ROW][COLUMN], data2[ROW][COLUMN], data3[ROW][COLUMN];
        void input()
        {
            std::cout << "Enter the elements one at a time" << std::endl;
            for(int i = 0; i < ROW; i++)
            {
                for(int j = 0; j < COLUMN; j++)
                {
                    std::cout << "(1) Enter the value for m" << i << j << ": ";
                    std::cin >> data1[i][j];
                }
            }
            std::cout << "\n";
            for(int i = 0; i < ROW; i++)
            {
                for(int j = 0; j < COLUMN; j++)
                {
                    std::cout << "(2) Enter the value for m" << i << j << ": ";
                    std::cin >> data2[i][j];
                }
            }
            std::cout << "\n";
        }
        void addMatrices()
        {
            for(int i = 0; i < ROW; i++)
            {
                for(int j = 0; j < COLUMN; j++)
                {
                    data3[i][j] = data1[i][j] + data2[i][j];
                }
            }
        }
        void displayTotalMatrices()
        {
            std::cout << "Added 3rd Matrix:" << std::endl;
            for(int i = 0; i < ROW; i++)
            {
                for(int j = 0; j < COLUMN; j++)
                {
                    std::cout << "\t" << data3[i][j] << " ";
                }
                std::cout << "\n";
            }
        }
};

int main()
{
    Matrix3 object;
    object.input();
    object.addMatrices();
    object.displayTotalMatrices();
    return 0;
}
