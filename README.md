# Midterm Exam Instructions

Midterm Exam is for Android-Advanced course Students of KBTU Fall 2023-2024

## Installation

Use git clone command to fetch the project.

```bash
git clone https://github.com/estharossa/avia.git
```

## About project

This project simulates an application for selling air tickets. The application has only one page for issuing tickets.

All necessary libraries are already registered in the build.gradle file.

Offer - class which holds an information about air ticket, including deparure/arrival location, time, airline, duration and etc.

ApiClient - a Retrofit based http client. Use it for your network response.


## Tasks

1. Offer list is taken from `FakeService` object, which is actually a list of hardcoded `Offer` objects. Add a GET request using Retrofit to fetch offer list from [here](https://my-json-server.typicode.com/estharossa/android-avia-db/db). Use **ViewModel + LiveData** to fetch data from network and show the UI.
2. Offer list is displayed using Recycler View, but it uses not optimized method `notifyDataSetChanged()`. Add Diff.Util implementation for the recycler view
3. Add a functionality to sort offer list by **price, duration, departure time.** 
Hint: SortBottomSheetFragment.

Bonus Task: add images of airlines using Glide. There is already an ImageView for you.

## Submission

Create a pull request with your changes targeting branch **main**. 
Include your name, surname and ID in a pull request description.

## License

[MIT](https://choosealicense.com/licenses/mit/)
