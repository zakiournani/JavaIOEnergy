# Comparing the Energy Consumption ofJava I/O Libraries and Methods

## Repository Description

this repository contains the source code used to run the microbenchmarks used for this paper, examples on how to substiture real projects I/O methods, and raw data from running the experiments on a test machine.
The repository is organized as follows :
- Micro-Benchmarks : contains the code of the Java micro-becnhmarks.
- Benchmarks : contains exmaples on how to subtiture the I/O method on 4 projects.
- Data : contains raw data of running experiments on our Intel i7-6600U testing computer.

The content of Data is seperated in multiple CSV files for an easier manipulation.
To interpret the data just import the needed CSV files and draw the plot you want to see, for example:

```python
data = pd.read_csv("readWholeFile.csv")
data.columns = ['Size','Method','Energy','Time']
fig_dims = (10, 6)
fig, ax = plt.subplots(figsize=fig_dims)
g=sns.lineplot(y="Energy", x="Size", ax=ax,  data=data, hue="Method")
```
