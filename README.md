# youglish-roam-dutch
A roam/render component for Roam Research that uses youglish to search videos in Dutch 

## Demo of Usage

![](https://github.com/clarapastore/youglish-roam-dutch/blob/main/demo.gif)

1) Writing a word in Dutch to search videos for
2) Creating a block underneath the word to call the component
3) Calling the roam/render component with a roam/templates template
4) Clicking on the search button to start the search based on what's on the parent block
5) Stopping the component with the stop button


## Installation Instructions

For this component to be used properly, we'll need to do two things:

- create a new template on your Roam graph
- installing the code in the [core.cljs](https://github.com/clarapastore/youglish-roam-dutch/blob/main/core.cljs) file as a render component as the content of the template

This will allow us to call the component any time we want.

### Creating a new template

- Navigate to the page where you'll want to store the template. This can be any page.
- Type /template on a block and hit enter. This will allow us to create a new template.
- Next to the `[[roam/templates]]` link, write the name of the template. You can use anything for it, like "Youglish Search" or "Youglish Dutch"
- add a child block to the template. We will install our component on this block.

If you want to read more on creating templates in Roam, [check this video out](https://www.youtube.com/watch?v=O_-lhwprLXs&ab_channel=ProductivityAcademy). 


## Installing the render component

- Before pasting the code, we need to make sure we have toggled on the ability to add custom components on our graph.
- To do this, click on the three-dot menu at the top-right of your graph, then navigate to Settings->User Code and toggle "Allow custom components on"
- Go back to the child block of the template and add some temporary content (we'll be adding the render syntax later on this block) like "hello" or "-"
- add a child block underneath this one and create a clojure code block. To do this, type /clojure and hit enter
- inside this code block, paste the content that's on the [core.cljs](https://github.com/clarapastore/youglish-roam-dutch/blob/main/core.cljs) file
- get the block reference of this code block (by right-clicking on the bullet -> copy block ref)
- go to the parent block (the one where we put the temporary content) and change the content to `{{[[roam/render]]: }}`
- after the colon, paste the block reference of the code block. The result will look something like this: `{{[[roam/render]]: ((adXeqOYBk))}}` (note that the block reference will have different letters and numbers than the ones in this example)

Now, you will be able to use this render compnent as a template anytime you need.

TODO: add demo loom

TODO: add instructions on how to change language
