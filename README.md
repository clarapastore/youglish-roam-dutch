# youglish-roam-dutch
A roam/render component for [Roam Research](https://roamresearch.com/) that uses [Youglish](https://youglish.com/) to search youtube videos in Dutch (language customizable)

## Intro

This component was created to replace [a smartblock](https://github.com/dvargas92495/SmartBlocks/issues/114) created by [Sangmin Ahn](https://github.com/gijigae) that used Youglish in almost the same way. Now that smartblocks are part of the Roam Depot marketplace, it's not possible to inject javascript into them anymore (for security reasons). Since the Youglish smartblock worked by injecting javascript into the graph, it's not usable anymore. 

Hence this roam/render component.

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


### Installing the render component

- Before pasting the code, we need to make sure we have toggled on the ability to add custom components on our graph.
- To do this, click on the three-dot menu at the top-right of your graph, then navigate to Settings->User Code and toggle "Allow custom components on"
- Go back to the child block of the template and add some temporary content (we'll be adding the render syntax later on this block) like "hello" or "-"
- add a child block underneath this one and create a clojure code block. To do this, type /clojure and hit enter
- inside this code block, paste the content that's on the [core.cljs](https://github.com/clarapastore/youglish-roam-dutch/blob/main/core.cljs) file
- get the block reference of this code block (by right-clicking on the bullet -> copy block ref)
- go to the parent block (the one where we put the temporary content) and change the content to `{{[[roam/render]]: }}`
- after the colon, paste the block reference of the code block. The result will look something like this: `{{[[roam/render]]: ((adXeqOYBk))}}` (note that the block reference will have different letters and numbers than the ones in this example)

Now, you will be able to use this render compnent as a template anytime you need, like shown on the [demo of usage](https://github.com/clarapastore/youglish-roam-dutch#demo-of-usage)

## Installation video

[Make sure to check out this video](https://www.loom.com/share/05b1e8dbf6134144801581e90727257e) to see a step by step installation of this component, along with demo usage and a short guide on how to change the search language from Dutch to anything supported in the [Youglish API](https://youglish.com/api/doc/js-api)

## Can I change the language from Dutch to something else?

Yes, you can change the language you want to use from Dutch to any of the languages supported by Youglish. Currently, these are the languages:

Arabic, Chinese, Dutch, English, French, German, Greek, Hebrew, Italian, Japanese, Korean, Polish, Portuguese, Russian, Spanish, Swedish, Thai, Turkish, Sign Languages

So, to change the language, you can replace the string "Dutch" on line 24 of the [core.cljs](https://github.com/clarapastore/youglish-roam-dutch/blob/main/core.cljs) file to any of the aforementioned languages. 

Make sure to check out [the final part of the installation video](https://www.loom.com/share/05b1e8dbf6134144801581e90727257e) to see this in action.
