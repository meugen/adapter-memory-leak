# adapter-memory-leak

This is an example of memory leak using adapters.

To reproduce launch app -> tap on any of the months -> wait a couple of seconds

In the status bar you'll see an icon. Tap on it to dump memory and view memory leak info.

To fix it go to MonthsFragment.kt and uncomment line #53
